<template>
  <div class="form">
    <form v-on:submit.prevent="addNewBook" class="new-book-form">
      <div class="title">
        <label for="title">Title:</label>
        <input id="title" class="title-input" type="text" v-model="newBook.title" />
      </div>
      <div class="author">
        <label for="author">Author:</label>
        <input id="author" class="author-input" type="text" v-model="newBook.author" />
      </div>
      <div class="isbn">
        <label for="isbn">ISBN:</label>
        <input id="isbn" class="isbn-input" type="text" v-model="newBook.isbn" />
      </div>
      <input type="submit" value="Save" />
      <input type="button" value="Cancel" v-on:click.prevent="resetForm" />
    </form>
  </div>
</template>

<script>
export default {
  name: "add-book",
  data() {
    return {
      newBook: {
        read: false,
      },
    };
  },
  methods: {
    addNewBook() {
      this.$store.commit("ADD_BOOK", this.newBook)
      this.resetForm();
    },
    resetForm() {
      this.showForm = false;
      this.newBook = {};
    },
  },
};
</script>