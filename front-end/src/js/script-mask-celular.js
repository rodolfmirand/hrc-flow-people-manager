document.addEventListener('DOMContentLoaded', () => {
    const phoneInput = document.getElementById('contato');

    phoneInput.addEventListener('input', formatPhone);

    function formatPhone(event) {
        const input = event.target;
        let value = input.value.replace(/\D/g, ''); // Remove todos os caracteres não numéricos

        if (value.length > 11) {
            value = value.slice(0, 11); // Limita o tamanho a 11 caracteres
        }

        // Adiciona os parênteses e o traço conforme o número de dígitos
        if (value.length > 10) {
            value = value.replace(/^(\d{2})(\d{5})(\d{4})$/, '($1) $2-$3');
        } else if (value.length > 6) {
            value = value.replace(/^(\d{2})(\d{4})(\d{0,4})$/, '($1) $2-$3');
        } else if (value.length > 1) {
            value = value.replace(/^(\d{2})(\d{0,4})$/, '($1) $2');
        } else if (value.length > 0) {
            value = value.replace(/^(\d{0,2})$/, '($1');
        }

        input.value = value;
    }
});