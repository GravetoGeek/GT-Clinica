<template>
<div>
  <navbar></navbar>
</div>
</template>

<script>
import medicos from "../../services/medicos";
import Navbar from "../components/base/navbar";
export default {
name: "Medicos",
  components: {Navbar},
  mounted() {
    medicos.listar()
        .then(resposta => {
          console.log(resposta)
        })
  }
}
</script>

<style scoped>

</style>