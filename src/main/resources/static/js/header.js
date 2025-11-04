//funções para o  header
document.addEventListener("DOMContentLoaded", () => {

    //desativar botão de busca quando barra de pesquisa está vazia (header principal)
    const input = document.getElementById("searchInput");
    const button = document.getElementById("searchButton");

    input.addEventListener("input", () => {
        button.disabled = input.value.trim() === "";
    });

    document.getElementById("searchForm").addEventListener("submit", (e) => {
        if (input.value.trim() === "") {
            e.preventDefault();
        }
    });

});
