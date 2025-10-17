// carregar hero title aleatório na homepage
document.addEventListener("DOMContentLoaded", () => {
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

  // Terms and conditions validation for create account form
  const createAccountForm = document.getElementById("createAccountForm")
  if (createAccountForm) {
    createAccountForm.addEventListener("submit", (e) => {
      const terms = document.getElementById("terms")
      if (!terms.checked) {
        e.preventDefault()
        alert("Deve aceitar os Termos e Condições para criar uma conta!")
        return
      }
    })
  }
})
