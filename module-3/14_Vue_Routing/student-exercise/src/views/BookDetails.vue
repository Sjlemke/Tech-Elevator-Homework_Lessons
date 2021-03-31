<template>
    <div id="app" class="main">
        <h1> {{ foundBook.title }} </h1>
        <h1> {{ foundBook.author }} </h1>
        <br>
        <img v-if="foundBook.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + foundBook.isbn + '-M.jpg'" />
        <br>
        <h3 v-if="foundBook.read">I have read this book.</h3>
        <h3 v-if="!foundBook.read">I have not read this book.</h3>
    </div>
</template>

<script>

export default {
    name: "book-details",
    computed: {
        foundBook() {
            return this.$store.state.books.find((bewk) => {
                return bewk.isbn == this.$route.params.isbn
            });
        }
    }
}
</script>
