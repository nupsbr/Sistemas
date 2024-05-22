const modals = document.querySelectorAll('.modal-container');

function openModal(modalIndex) {
    modals[modalIndex - 1].classList.add('active');
}

function closeModal() {
    modals.forEach(modal => {
        modal.classList.remove('active');
    });
}
function searchLanche() {
    // Obtém o valor digitado na barra de pesquisa
    var searchTerm = document.getElementById('searchInput').value;

    // Verifica se o valor não está vazio
    if (searchTerm.trim() !== '') {
        // Itera sobre os nomes dos lanches e verifica se o termo de pesquisa corresponde
        for (var i = 0; i < lanches.length; i++) {
            if (lanches[i][0].toLowerCase().includes(searchTerm.toLowerCase())) {
                // Se encontrar correspondência, abre o modal correspondente
                openModal(i + 1);
                return; // Sai da função após encontrar a primeira correspondência
            }
        }
        // Se nenhum lanche corresponder ao termo de pesquisa, exibe uma mensagem de erro
        alert('Nenhum lanche encontrado com o nome "' + searchTerm + '".');
    } else {
        // Se a barra de pesquisa estiver vazia, exibe uma mensagem de erro
        alert('Por favor, insira um termo de pesquisa.');
    }
}

