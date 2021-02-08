<template>
<div>
  <navbar></navbar>
</div>
</template>

<script>
import enfermeiros from "../../services/enfermeiros";
import Navbar from "../components/base/navbar";

export default {
name: "Enfermeiros",
  components: {Navbar},
  mounted() {
    enfermeiros.listar()
        .then(resposta => {
          console.log(resposta)
        })
  }
}
</script>

<style scoped>

</style>