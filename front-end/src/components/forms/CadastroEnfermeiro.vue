<template>
  <div class="cadastro-enfermeiro">
    <main class="form-enfermeiro">
      <h1 class="h3 mb-3 fw-normal">Cadastrar Enfermeiro</h1>
      <b-form @submit.prevent="submit">
        <b-form-input v-model="form.nome" type="text" class="form-control" placeholder="Nome"></b-form-input>
        <b-form-input v-model="form.cpf" type="text" class="form-control" placeholder="CPF"></b-form-input>
        <b-form-input v-model="form.email" type="email" class="form-control" placeholder="Endereço de Email"></b-form-input>
        <b-form-input v-model="form.senha" type="password" class="form-control" placeholder="Senha"></b-form-input>
        <b-button type="submit" class="w-100 btn btn-lg btn-primary">Cadastrar</b-button>

      </b-form>
    </main>
  </div>
</template>

<script>
import http from "../../../services/config";

export default {
  name: "CadastroEnfermeiro",
  data(){
    return {
      form:{
        email:null,
        senha:null,
        nome:null,
        cpf:null
      }
    }
  },

  methods:{
    submit(){
      http.post('http://localhost:8080/api/enfermeiros',this.form)
          .then(resposta => {
            console.log(resposta.data)
          })
    }
  },
  mounted(){

  }
}
</script>

<style scoped>

</style>