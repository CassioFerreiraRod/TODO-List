function limparCampos() {
    let formulario = document.getElementById('formulario')
    for (let elementos of formulario) {
        elementos.value = ''
    }
}

function adicionaZeroAEsquerda(numero) {
    if (numero < 10) {
        return `0${numero.toString()}`
    } else {
        return numero.toString()
    }
}

function formatarData(timeStamp) {
    let dia = adicionaZeroAEsquerda(new Date(timeStamp).getDate())
    let mes = adicionaZeroAEsquerda(new Date(timeStamp).getMonth() + 1)
    let ano = adicionaZeroAEsquerda(new Date(timeStamp).getFullYear())
    return `${dia}/${mes}/${ano}`
}

document.getElementById('botaoCriar').onclick = function () {
    let nomeTarefa = document.getElementById('nome').value
    let descricaoTarefa = document.getElementById('descricao').value
    let dataTarefa = document.getElementById('data').value
    let prioridadeTarefa = document.getElementById('prioridade').value
    let categoriaTarefa = document.getElementById('categoria').value
    let statusTarefa = document.getElementById('status').value
    if (nomeTarefa && descricaoTarefa && dataTarefa && prioridadeTarefa && categoriaTarefa && statusTarefa) {
        document.getElementById('tarefas_criadas').innerHTML += `<tr>
                          <td>${nomeTarefa}</td>
                          <td>${descricaoTarefa}</td>
                          <td>${formatarData(dataTarefa)}</td>
                          <td>${prioridadeTarefa}</td>
                          <td>${categoriaTarefa}</td>
                          <td>${statusTarefa}</td>
                          <td>
                          <button type="button" class="btn btn-info btn-sm"  id="editar" onclick="editarLinha(this)">Editar</button>
                          <button type="button" class="btn btn-danger btn-sm"  id="excluir" onclick="excluirLinha(this)">Excluir</button>
                          </td>
                      </tr>`
        limparCampos()
    } else {
        alert('Preencha todos os campos.')
    }
}

function excluirLinha(botaoExcluir) {
    var linha = botaoExcluir.parentNode.parentNode;
    linha.parentNode.removeChild(linha);
}

function editarLinha(botaoEditar) {
    var linha = botaoEditar.parentNode.parentNode;
    var celulas = linha.getElementsByTagName('td');
    celulas[6].innerHTML =
        `<button type="button" class="btn btn-success btn-sm" id="salvar" onclick="salvarEdicao(this)">Salvar</button>`
    for (var i = 0; i < celulas.length - 1; i++) {
        celulas[i].contentEditable = true;
    }
}

function salvarEdicao(botaoSalvar) {
    var linha = botaoSalvar.parentNode.parentNode;
    var celulas = linha.getElementsByTagName('td');
    celulas[6].innerHTML =
    `<button type="button" class="btn btn-info btn-sm" id="editar" onClick="editarLinha(this)">Editar</button>
    <button type="button" class="btn btn-danger btn-sm" id="excluir" onClick="excluirLinha(this)">Excluir</button>`
    for (var i = 0; i < celulas.length - 1; i++) {
        celulas[i].contentEditable = false;
    }
}
