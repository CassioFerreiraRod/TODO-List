function limparcampos() {
    document.getElementById('nome').value = '';
    document.getElementById('descricao').value = '';
    document.getElementById('data').value = '';
    document.getElementById('prioridade').value = '';
    document.getElementById('categoria').value = '';
    document.getElementById('status').value = '';
}

document.getElementById('botaoCriar').onclick = function () {
    let nomeTarefa = document.getElementById('nome').value
    let descricaoTarefa = document.getElementById('descricao').value
    let dataTarefa = document.getElementById('data').value
    let prioridadeTarefa = document.getElementById('prioridade').value
    let categoriaTarefa = document.getElementById('categoria').value
    let statusTarefa = document.getElementById('status').value
    if (nomeTarefa && descricaoTarefa && dataTarefa && prioridadeTarefa && categoriaTarefa && statusTarefa) {
        document.getElementById('tarefas').innerHTML += `<tr>
                          <td>${nomeTarefa}</td>
                          <td>${descricaoTarefa}</td>
                          <td>${dataTarefa}</td>
                          <td>${prioridadeTarefa}</td>
                          <td>${categoriaTarefa}</td>
                          <td>${statusTarefa}</td>
                          <td><button type="button" class="btn-close" aria-label="Close" id="excluir"  onclick="excluirLinha(this)"></button></td>
                      </tr>`
        limparcampos()
    } else {
        alert('Preencha todos os campos.')
    }
}

function excluirLinha(botaoExcluir) {
    var linha = botaoExcluir.parentNode.parentNode; // Obtenha a linha associada ao botão
    linha.parentNode.removeChild(linha); // Remova a linha da tabela
}