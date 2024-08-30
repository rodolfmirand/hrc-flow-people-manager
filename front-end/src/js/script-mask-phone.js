document.addEventListener('DOMContentLoaded', () => {
    const phoneInput = document.getElementById('contato');

    phoneInput.addEventListener('input', formatPhone);

    function formatPhone(event) {
        const input = event.target;
        let value = input.value.replace(/\D/g, ''); // Remove todos os caracteres não numéricos

        if (value.length > 11) {
            value = value.slice(0, 11); // Limita o tamanho a 11 caracteres
        }

        if (value.length > 6) {
            value = value.replace(/^(\d{2})(\d{5})(\d{0,4})/, '($1) $2-$3');
        } else if (value.length > 2) {
            value = value.replace(/^(\d{2})(\d{0,5})/, '($1) $2');
        } else {
            value = value.replace(/^(\d*)/, '($1');
        }

        input.value = value;
    }
});