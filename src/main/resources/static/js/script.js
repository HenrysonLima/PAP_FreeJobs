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

  const resetButtons = document.querySelectorAll(".btn-reset-contact")
  resetButtons.forEach((button) => {
    button.addEventListener("click", () => {
      const contactNumber = button.getAttribute("data-contact")
      const selectElement = document.getElementById(`contactType${contactNumber}`)
      const inputElement = document.getElementById(`contact${contactNumber}`)

      if (selectElement && inputElement) {
        selectElement.value = "none"
        inputElement.value = ""
      }
    })
  })






})
