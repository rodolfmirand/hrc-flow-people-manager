const selectElement = document.getElementById('tipo-documento');
const inputElement = document.getElementById('documento');

// Função para aplicar máscara de CPF
function maskCPF(value) {
    return value
        .replace(/\D/g, '') // Remove tudo que não for dígito
        .replace(/(\d{3})(\d)/, '$1.$2') // Aplica ponto entre os três primeiros dígitos
        .replace(/(\d{3})(\d)/, '$1.$2') // Aplica ponto entre os três seguintes
        .replace(/(\d{3})(\d{1,2})$/, '$1-$2'); // Aplica traço entre os últimos dois dígitos
}

// Função para aplicar máscara de RG
function maskRG(value) {
    return value
        .replace(/\D/g, '') // Remove tudo que não for dígito
        .replace(/(\d{2})(\d)/, '$1.$2') // Aplica ponto entre os dois primeiros dígitos
        .replace(/(\d{3})(\d)/, '$1.$2') // Aplica ponto entre os três seguintes
        .replace(/(\d{3})(\d{1})$/, '$1-$2'); // Aplica traço no final
}

// Função para aplicar máscara de CNH
function maskCNH(value) {
    return value.replace(/\D/g, '').replace(/(\d{3})(\d)/g, '$1 $2'); // Separa os números em blocos de 3
}

selectElement.addEventListener('change', function () {
    const selectedValue = this.value;

    if (selectedValue) {
        inputElement.disabled = false;
        inputElement.value = ''; // Limpa o campo quando mudar a seleção

        if (selectedValue === 'cpf') {
            inputElement.placeholder = 'Digite o CPF';
            inputElement.maxLength = 14; // Limita o tamanho máximo para CPF (incluindo pontos e traço)
        } else if (selectedValue === 'rg') {
            inputElement.placeholder = 'Digite o RG';
            inputElement.maxLength = 12; // Limita o tamanho para RG
        } else if (selectedValue === 'cnh') {
            inputElement.placeholder = 'Digite a CNH';
            inputElement.maxLength = 12; // Limita o tamanho para CNH
        }
    } else {
        inputElement.disabled = true;
        inputElement.value = '';
        inputElement.placeholder = 'Digite o documento';
    }
});

inputElement.addEventListener('input', function () {
    const selectedValue = selectElement.value;
    let value = inputElement.value;

    // Aplica a máscara correta com base na seleção
    if (selectedValue === 'cpf') {
        inputElement.value = maskCPF(value);
    } else if (selectedValue === 'rg') {
        inputElement.value = maskRG(value);
    } else if (selectedValue === 'cnh') {
        inputElement.value = maskCNH(value);
    }
});