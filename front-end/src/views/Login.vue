<template>
<div class="login">
  <navbar></navbar>
  <main class="form-signin">
    <h1 class="h3 mb-3 fw-normal">Já possuo conta!</h1>
    <b-form @submit.prevent="submit">
        <b-form-input v-model="form.email" type="email" class="form-control" placeholder="Endereço de Email"></b-form-input>
        <b-form-input v-model="form.senha" type="password" class="form-control" placeholder="Senha"></b-form-input>
        <b-form-select v-model="form.cargo" :options="options"></b-form-select>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Lembrar-me
        </label>
      </div>
      <b-button type="submit" class="w-100 btn btn-lg btn-primary">Entrar</b-button>

    </b-form>
  </main>
</div>
</template>

<script>
import Navbar from "../components/base/navbar";
import http from '../../services/config'


export default {
name: "Login",
  components: {Navbar},
  data(){
  return {
    form:{
      email:null,
      senha:null,
      cargo:null
    },
    options:[
      {value:1,text:"Médico"},
      {value:2,text:"Enfermeiro"},
    ]
  }
  },

  methods:{
    submit(){
      http.post('http://localhost:8080/api/auth',this.form)
      .then(resposta => {
        console.log(resposta.data)
      })
    },
    login() {
      http.get('https://servicodados.ibge.gov.br/api/v1/localidades/estados')
          .then(resposta => {
              console.log(resposta.data)
            }
          )
    }
  },
  mounted(){
    this.login();
  }
}
</script>

<style scoped>
html,
body {
  height: 100%;
}

body {
  display: flex;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}
.form-signin .checkbox {
  font-weight: 400;
}
.form-signin .form-control {
  position: relative;
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>