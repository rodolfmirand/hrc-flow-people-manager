const nomesMeses = [
  'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho',
  'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'
];

let mesAtual = new Date().getMonth(); // Mês atual (0 = Janeiro, 11 = Dezembro)
let anoAtual = new Date().getFullYear(); // Ano atual

// Função para gerar o calendário
function gerarCalendario(mes, ano) {
  const diasContainer = document.getElementById('dias-calendario');
  diasContainer.innerHTML = ''; // Limpa o conteúdo anterior

  // Atualiza o nome do mês
  document.getElementById('nome-mes').textContent = nomesMeses[mes] + ' ' + ano;

  // Obter o primeiro dia do mês e o número de dias no mês
  const primeiroDia = new Date(ano, mes, 1).getDay();
  const diasNoMes = new Date(ano, mes + 1, 0).getDate();

  // Preencher os espaços em branco antes do primeiro dia
  for (let i = 0; i < primeiroDia; i++) {
    const diaVazio = document.createElement('div');
    diaVazio.classList.add('dia');
    diasContainer.appendChild(diaVazio);
  }

  // Preencher os dias do mês
  for (let dia = 1; dia <= diasNoMes; dia++) {
    const diaDiv = document.createElement('div');
    diaDiv.classList.add('dia');
    diaDiv.innerHTML = `${dia} <i class="bi bi-plus-circle-fill"></i>`;
    diasContainer.appendChild(diaDiv);
  }
}

// Função para navegar para o mês anterior
function mesAnterior() {
  mesAtual--;
  if (mesAtual < 0) {
    mesAtual = 11; // Vai para Dezembro do ano anterior
    anoAtual--;
  }
  gerarCalendario(mesAtual, anoAtual);
}

// Função para navegar para o próximo mês
function proximoMes() {
  mesAtual++;
  if (mesAtual > 11) {
    mesAtual = 0; // Vai para Janeiro do próximo ano
    anoAtual++;
  }
  gerarCalendario(mesAtual, anoAtual);
}

// Eventos de clique para os botões
document.getElementById('bttn-anterior').addEventListener('click', mesAnterior);
document.getElementById('bttn-proximo').addEventListener('click', proximoMes);

// Gera o calendário para o mês atual quando a página é carregada
gerarCalendario(mesAtual, anoAtual);