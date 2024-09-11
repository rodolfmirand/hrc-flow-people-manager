const inputElement = document.getElementById('horario');

inputElement.addEventListener('input', function () {
    let value = inputElement.value.replace(/\D/g, ''); // Remove tudo que não for dígito

    if (value.length > 2) {
        value = value.slice(0, 2) + ':' + value.slice(2, 4); // Adiciona os dois pontos automaticamente
    }

    inputElement.value = value;
});

inputElement.addEventListener('blur', function () {
    const time = inputElement.value.split(':');
    let hour = parseInt(time[0], 10);
    let minute = parseInt(time[1], 10);

    // Ajusta o horário se o valor da hora for maior que 24
    if (hour > 23 || isNaN(hour)) {
        hour = 23;
        minute = 59;
    } else if (minute > 59 || isNaN(minute)) {
        minute = 59;
    }

    // Se o valor da hora for válido e menor que 24, mas minutos são inválidos, ajusta para o último minuto válido
    if (hour <= 23 && (minute > 59 || isNaN(minute))) {
        minute = 59;
    }

    // Formata a hora e os minutos com zero à esquerda, se necessário
    inputElement.value = `${String(hour).padStart(2, '0')}:${String(minute).padStart(2, '0')}`;
});