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
                      </tr>`
    } else {
        alert('Preencha todos os campos.')
    }

}