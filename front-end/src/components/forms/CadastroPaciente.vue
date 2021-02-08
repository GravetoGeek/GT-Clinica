<template>
  <div class="cadastro-paciente">
    <h1 class="h3 mb-3 fw-normal">Cadastrar Paciente</h1>
    <b-form @submit.prevent="submit">
  <b-input v-model="form.nome" type="text" placeholder="Nome" required></b-input>
  <b-input v-model="form.cpf" type="text" placeholder="CPF" required></b-input>
  <b-input v-model="form.datanasc" type="date" placeholder="Data de nascimento"></b-input>
  <b-input v-model="form.peso" type="number" step="0.01" placeholder="Peso"></b-input>
  <b-input v-model="form.altura" type="number" step="0.01" placeholder="Altura"></b-input>
  <b-form-select v-model="form.uf" :options="options" required></b-form-select>
  <b-button type="submit" class="w-100 btn btn-lg btn-primary">Cadastrar</b-button>
</b-form>
    {{form.nome}}
    {{form.cpf}}
    {{form.datanasc}}
    {{form.peso}}
    {{form.altura}}
    {{form.uf}}
  </div>
</template>

<script>
import http from "../../../services/config";

export default {
  name: "CadastroPaciente",
  data(){
    return {
      form:{
        datanasc:null,
        altura:null,
        peso:null,
        nome:null,
        cpf:null,
        uf:null
      },
      options:[]
    }
  },

  methods:{
    submit(){
      http.post('http://localhost:8080/api/pacientes',JSON.parse(this.form),{
        headers: {
          // Overwrite Axios's automatically set Content-Type
          'Content-Type': 'application/json'
        }
      }
      )
          .then(resposta => {
            console.log(this.form)
            console.log(resposta.data)
          })
    }
  },
  mounted(){
    http.get('https://servicodados.ibge.gov.br/api/v1/localidades/estados')
        .then(resposta => {
          console.log(resposta.data)
              for (const respostaElement of resposta.data) {
                this.options.push({value:respostaElement.sigla,text:respostaElement.nome})
              }
        }
        )
  }
}
</script>

<style scoped>
.cadastro-paciente {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}
</style>