import java.awt.BorderLayout;
//import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Veiculo extends JFrame implements ActionListener {
	private String placa;
	private String fabricante;
	private String modelo;
	private int anoFabricacao;
	private float valor;
	private Date dataCompra;
	
	private JButton btCadastrar,btAlterar, btExcluir,btPesquisar,btLimpar,btSair;
	private JLabel lbplaca, lbfabricante, lbmodelo, lbdatacompra,lbano,lbvalor;
	private JTextField txplaca,txtModelo,txdatacompra,txano,txvalor;
	private JComboBox<String> combo;
	
	public Veiculo() {
        super("Controle de Frota - Cadastro de Veículos");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //FECHAR O PROGRAMA
         
        //setLayout(new FlowLayout());
        
        
        JPanel inputPanel = new JPanel();//gridlayout para os JLabel e JTextField
        inputPanel.setLayout(new GridLayout(3, 4,5,5));// 4 linhas(JLabel) 2 colunas(JTextField

        JPanel painelBotao = new JPanel();//gridlayout somente para os boteos embaixo
        painelBotao.setLayout(new GridLayout(1, 4,2,2));// 1 linha (botoes)
        
        // instaciar o Objeto e Inicializar
        
        //botoes (painelBotao)
        btCadastrar = new JButton("Cadastrar");
        btAlterar = new JButton("Alterar");
        btExcluir = new JButton("Excluir");
        btPesquisar = new JButton("Pesquisar");
        btLimpar = new JButton("Limpar");
        btSair = new JButton("Sair");
        
        //label e textfiel (inputPanel)
        lbplaca = new JLabel("Placa ");
        lbfabricante= new JLabel("Fabricante ");
        lbmodelo = new JLabel("Modelo ");
        lbdatacompra = new JLabel("Data Compra ");
        lbano = new JLabel("Ano");
        lbvalor = new JLabel("Valor (R$)");

        combo = new JComboBox<>(new String[]{"CHEVROLET","HONDA","FERRARI", "Outra Opção"});
        
        txplaca = new JTextField(20);
        txano = new JTextField(20);
        //txfabricante = new JTextField(20);
        txtModelo = new JTextField(20);
        txdatacompra = new JTextField("data");
        txvalor = new JTextField(20);
        
        // ADICIONAR A TELA

        //add label e textfiel em (inputPanel)
        inputPanel.add(lbplaca);
        inputPanel.add(txplaca);
        inputPanel.add(lbfabricante);
        inputPanel.add(combo);
        inputPanel.add(lbmodelo);
        inputPanel.add(txtModelo);
        inputPanel.add(lbano);
        inputPanel.add(txano);
        inputPanel.add(lbdatacompra);
        inputPanel.add(txdatacompra);       
        inputPanel.add(lbvalor);
        inputPanel.add(txvalor);
        
        //add botoes em (painelBotao)
        painelBotao.add(btCadastrar);
        painelBotao.add(btAlterar);
        painelBotao.add(btExcluir);
        painelBotao.add(btPesquisar);
        painelBotao.add(btLimpar);       
        painelBotao.add(btSair);
                     
        add(inputPanel, BorderLayout.NORTH); // adiciona o painel ao centro do JFrame
        add(painelBotao, BorderLayout.SOUTH); // adiciona os botoes na parte sul do JFrame
        
        setVisible(true); // Tornar o JFrame visível
    }

	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new Veiculo()); // Execute a criação do JFrame!!
	    }

	 public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		if(evento.getSource() == txtModelo){
			txtModelo.setText(txtModelo.getText().toUpperCase());
			}
			if(evento.getSource() == btCadastrar){
			cadastrar();
			}
			if(evento.getSource() == btAlterar){
			alterar();
			}
			if(evento.getSource() == btExcluir){
			excluir();
			}
			if(evento.getSource() == btPesquisar){
			pesquisar();
			}
			if(evento.getSource() == btLimpar){
				limpar();
			}
			if(evento.getSource() == btSair){
			dispose();
			}

			}
}



