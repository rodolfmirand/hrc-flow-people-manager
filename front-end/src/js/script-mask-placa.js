document.addEventListener('DOMContentLoaded', () => {
    const inputField = document.getElementById('placa');

    inputField.addEventListener('input', enforceUppercaseAndAlphanumeric);

    function enforceUppercaseAndAlphanumeric(event) {
        const input = event.target;
        let value = input.value;

        if (value.length > 7) {
            value = value.slice(0, 7); // Limita o tamanho a 11 caracteres
        }

        // Remove caracteres que não são números ou letras maiúsculas
        value = value.replace(/[^0-9a-zA-Z]/g, '');

        // Converte todas as letras para maiúsculas
        value = value.toUpperCase();

        // Atualiza o valor do input com os caracteres filtrados
        input.value = value;
    }
});