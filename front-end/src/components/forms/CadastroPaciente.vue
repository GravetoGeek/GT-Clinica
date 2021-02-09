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
  </div>
</template>

<script>

import axios from "axios";
export default {
  name: "CadastroPaciente",
  data(){
    return {
      form:{
        nome:"",
        cpf:"",
        datanasc:"",
        peso:"",
        altura:"",
        uf:""
      },
      options:[]
    }
  },

  methods:{
    async submit(){
      let cadastrar = await axios.post('/pacientes',this.form)
      .then(resposta =>{
        console.log(resposta.data)
      })
      .catch(e =>{
        console.log(e)
      })

      console.log(cadastrar)
    }
  },
  mounted(){
    axios.get('https://servicodados.ibge.gov.br/api/v1/localidades/estados')
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