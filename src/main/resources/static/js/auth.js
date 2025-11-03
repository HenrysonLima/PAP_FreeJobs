/* Funções relacionadas com campos de auth */
document.addEventListener("DOMContentLoaded", () => {

    // Botões de limpar campos de contactos (criar e editar perfil)
    const resetButtons = document.querySelectorAll(".btn-reset-contact");
    resetButtons.forEach((button) => {
        button.addEventListener("click", () => {
            const contactNumber = button.getAttribute("data-contact");
            const selectElement = document.getElementById(`contactType${contactNumber}`);
            const inputElement = document.getElementById(`contact${contactNumber}`);

            if (selectElement && inputElement) {
                selectElement.value = "none";
                inputElement.value = "";
            }
        });
    });

    // Steps no formulário de criar perfil
    const steps = document.querySelectorAll(".form-step");
    let currentStep = 0;

    function showStep(step) {
        steps.forEach((s, i) => s.classList.toggle("active", i === step));
    }

    document.querySelectorAll(".btn-next").forEach(btn => {
        btn.addEventListener("click", () => {
            if (currentStep < steps.length - 1) {
                currentStep++;
                showStep(currentStep);
            }
        });
    });

    document.querySelectorAll(".btn-prev").forEach(btn => {
        btn.addEventListener("click", () => {
            if (currentStep > 0) {
                currentStep--;
                showStep(currentStep);
            }
        });
    });

    showStep(currentStep);

    // Recuperar Senha – Validação de campos
    const recoveryForm = document.getElementById("recoveryForm");
    if (recoveryForm) {
        const newPassword = document.getElementById("newPassword");
        const confirmPassword = document.getElementById("confirmPassword");
        const feedback = document.getElementById("passwordFeedback");
        const submitBtn = recoveryForm.querySelector("button[type='submit']");

        // desativar botão no início
        submitBtn.disabled = true;

        function validatePasswords() {
            const hasValues = newPassword.value && confirmPassword.value;
            const match = newPassword.value === confirmPassword.value;

            if (!hasValues) {
                feedback.textContent = "";
                submitBtn.disabled = true;
                return;
            }

            if (match) {
                feedback.textContent = "✅ As senhas coincidem.";
                feedback.style.color = "#28a745";
                submitBtn.disabled = false;
            } else {
                feedback.textContent = "❌ As senhas não coincidem.";
                feedback.style.color = "#dc3545";
                submitBtn.disabled = true;
            }
        }

        newPassword.addEventListener("input", validatePasswords);
        confirmPassword.addEventListener("input", validatePasswords);

        recoveryForm.addEventListener("submit", (e) => {
            if (newPassword.value !== confirmPassword.value) {
                e.preventDefault();
                alert("As senhas não coincidem. Por favor, verifique.");
            }
        });
    }
});

// Botão show/hide nos campos de senha
function togglePasswordVisibility(inputId, button) {
    const input = document.getElementById(inputId);
    const img = button.querySelector("img");

    if (input.type === "password") {
        input.type = "text";
        img.src = "/imagens/hide_icon.png";
    } else {
        input.type = "password";
        img.src = "/imagens/show_icon.png";
    }
}
