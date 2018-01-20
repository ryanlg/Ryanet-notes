import Vue from 'vue'
import axios from 'axios'
import 'mathjax'

export default Vue.component('upload', {

    data() {

        return {

            noteWrappers: [new RNNewFileDomWrapper()], // the default one for display
            noteHtml: ''
        };
    },

    methods: {

        onFileChange(event: HTMLInputEvent, index: number) {

            const vueSelf = this;
            const capturedIndex = index; // TODO: do I have to do this?
            const length = this.noteWrappers.length;

            if (index >= 0 && index < length) {

                // there should only be one file
                let fileArray = event.target.files;
                if (fileArray != null) {

                    const firstFile = fileArray[0];

                    let file = new RNNewFile();
                    file.name = firstFile.name;
                    // Make it look better
                    file.trimExtentionFilename();
                    file.camelToRegularFilename();

                    var reader = new FileReader();
                    reader.onload = function (e) {

                        file.content = reader.result;

                        // wrap it
                        let noteWrapper = new RNNewFileDomWrapper();
                        noteWrapper.note = file;
                        noteWrapper.uploaded = true;

                        // Or Vue can't detect the change
                        Vue.set(vueSelf.noteWrappers, capturedIndex, noteWrapper);
                    }
                    reader.readAsText(firstFile);
                }
            }
        },

        onSubmit() {

            let config = {
                headers: { "content-type": "application/json; charset=utf-8" }
            }

            let data = {
                "note": this.files
            }

            axios.post("http://localhost:8080/Ryanet/api/v1/note/new", JSON.stringify(data), config)
                .then((response) => {

                    this.noteHtml = response.data;
                });
        },

        onAddMoreNoteInput() {

            this.noteWrappers.push(new RNNewFileDomWrapper);
        },

        canAddMoreNoteInput() {

            const length = this.noteWrappers.length;
            const lastFileWrapper: RNNewFileDomWrapper = this.noteWrappers[length - 1];
            return lastFileWrapper.uploaded;
        }
    },

    watch: {
        noteHtml: function () {

            // DOM update happens on the next tick.
            // For Mathjax to work equations has to be in the DOM already.
            Vue.nextTick(() => {

                MathJax.Hub.Queue(["Typeset", MathJax.Hub, "file_content"]);
            })
        }
    }

});

interface HTMLInputEvent extends Event {
    target: HTMLInputElement & EventTarget;
}
class RNNewFile {

    name: string;
    content: string;

    trimExtentionFilename(): void {

        this.name = this.name.replace(/\..+$/, '');
    }


    camelToRegularFilename(): void {

        this.name = this.name.replace(/([a-z])([A-Z])/g, '$1 $2');
    }
}

class RNNewFileDomWrapper {

    note: RNNewFile;
    uploaded: boolean;

    constructor(){
        this.note = new RNNewFile();
        this.uploaded = false;
    }
}