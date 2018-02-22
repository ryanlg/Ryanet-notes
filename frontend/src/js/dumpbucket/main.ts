import { default as textbox } from './components/textbox';
import { default as submitButton } from './components/submitbutton';

export default {

    components: {
        textbox,
        'submit-button': submitButton,
    },

    methods: {

        dump() {

            this.$refs.textbox.dump();
        },
    },
};
