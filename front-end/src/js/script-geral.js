function limparCampos() {
    var inptForm = document.querySelectorAll('.inpt-form');
    var selc = document.querySelectorAll('.selecao');
    var inptData = document.querySelectorAll('.inpt-form-data');
    var inpt = document.querySelectorAll('.inpt');

    inptForm.reset();
    inptData.reset();
    selc.reset(); 
    inpt.reset();
}