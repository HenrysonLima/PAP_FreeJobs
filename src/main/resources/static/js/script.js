document.addEventListener("DOMContentLoaded", () => {

  // carregar hero title aleatório na homepage
  const heroTitle = document.getElementById("heroTitle")
  if (heroTitle) {
    const titles = [
      "Conectando talentos a oportunidades.",
      "Aqui, ideias encontram quem sabe realizá-las.",
      "Clientes encontram soluções, freelancers encontram oportunidades.",
      "Mais que freelas, conexões de sucesso.",
      "Seu projeto, nossa rede.",
      "Juntos, fazemos acontecer.",
    ]
    const randomTitle = titles[Math.floor(Math.random() * titles.length)]
    heroTitle.textContent = randomTitle
  }

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


  
})