from flask import Flask, render_template, request
import mysql.connector
from mysql.connector import Error

app = Flask(__name__)

# Função para obter conexão com o banco de dados


def get_db_connection():
    try:
        connection = mysql.connector.connect(
            host="localhost",
            user="root",
            password="root",
            database="bancodados2"   # substitua 'seu_banco' pelo nome do seu banco de dados
        )
        if connection.is_connected():
            return connection
    except Error as e:
        print("Erro ao conectar ao MySQL", e)
        return None

# Função para buscar lanches do banco de dados


def get_lanches():
    conn = get_db_connection()
    if conn:
        cursor = conn.cursor()
        cursor.execute("SELECT nome, descricao, imagem,imagens FROM tabelalanche2")
        lanches = cursor.fetchall()
        cursor.close()
        conn.close()
        return lanches
    else:
        return []


@app.route('/')
def index():
    lanches = get_lanches()
    lanche_id = request.args.get('lanche_id', None)
    return render_template('index.html', lanches=lanches, lanche_id=lanche_id, enumerate=enumerate)

if __name__ == '__main__':
    app.run(debug=True)
