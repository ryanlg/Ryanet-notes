import Vue from 'vue'
import axios from 'axios'
import 'mathjax'

interface HTMLInputEvent extends Event {
    target: HTMLInputElement & EventTarget;
}

export default Vue.component('upload', {

    data() {

        return {

            files: [],
            noteHtml: ''
       };
    },

    methods: {

        onFileChange(event: HTMLInputEvent) {

            let fileList = event.target.files;
            if (fileList != null) {
                const vueSelf = this;
                const firstFile = fileList![0];

                // this.file.title = firstFile.name;
                let file = new RNFile();
                file.name = firstFile.name;

                var reader = new FileReader();
                reader.onload = function (e) {
                    // vueSelf.file.content = reader.result;
                    file.content = reader.result;
                    // Or Vue can't detect the change (with files[0])
                    Vue.set(vueSelf.files, 0, file);
                }
                reader.readAsText(firstFile);
            }
        },

        onSubmit() {

            let config = {
                headers: { "content-type": "application/json; charset=utf-8"}
            }

            let data = {
                "notes": this.files
            }

            axios.post("http://localhost:8080/Ryanet/api/v1/note/new", JSON.stringify(data), config)
                 .then( (response) => {

                    this.noteHtml = response.data;
            });
        },

        onHTMLChange() {

            MathJax.Hub.Queue(["Typeset", MathJax.Hub]);
        }
    }

});

class RNFile {

    name: String;
    content: String;
    createdTime: Date;
    modifiedTime: Date;
}