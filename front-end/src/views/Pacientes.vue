<template>
  <div>
    <navbar></navbar>
    <cadastro-paciente></cadastro-paciente>
    <b-table striped hover :items="items" :fields="fields"></b-table>
  </div>
</template>

<script>
import pacientes from "../../services/pacientes";
import Navbar from "../components/base/navbar";
import CadastroPaciente from "../components/forms/CadastroPaciente";

export default {
name: "Pacientes",
  components: {CadastroPaciente, Navbar},
  data(){
    return {
      fields:[
        {key:"idPaciente",label:"Id",sortable:true},
        {key:"nome",label:"Nome",sortable:true},
        {key:"cpf",label:"CPF",sortable:false},
        {key:"dataNasc",label:"Data de Nascimento",sortable:true},
        {key:"peso",label:"Peso",sortable:true},
        {key:"altura",label:"Altura",sortable:true},
        {key:"uf",label:"UF",sortable:true}
      ],
      items:null
    }
  },
  mounted() {
  pacientes.listar()
    .then(resposta => {
      this.items = resposta.data
    })
  }
}
</script>

<style scoped>

</style>