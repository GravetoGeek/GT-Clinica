<template>
  <div>
    <navbar></navbar>
    <cadastro-paciente></cadastro-paciente>
    <b-table striped hover :items="items" :fields="fields"></b-table>
  </div>
</template>

<script>
import Navbar from "../components/base/navbar";
import CadastroPaciente from "../components/forms/CadastroPaciente";
import axios from "axios";

export default {
name: "Pacientes",
  components: {CadastroPaciente, Navbar},
  data(){
    return {
      fields:[
        {key:"idpaciente",label:"Id",sortable:true},
        {key:"nome",label:"Nome",sortable:true},
        {key:"cpf",label:"CPF",sortable:false},
        {key:"datanasc",label:"Data de Nascimento",sortable:true},
        {key:"peso",label:"Peso",sortable:true},
        {key:"altura",label:"Altura",sortable:true},
        {key:"uf",label:"UF",sortable:true}
      ],
      items:null
    }
  },
  methods:{
    async listar(){
      return await axios.get('/pacientes')
          .then(resposta => {
            console.log(resposta.data)
            this.items = resposta.data
          })
    }
  },
  mounted() {
    this.listar();
  }


}
</script>

<style scoped>

</style>