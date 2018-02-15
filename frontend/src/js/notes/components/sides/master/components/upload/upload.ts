import Modal from '@notes/components/modal';

export default {

    components: {

        Modal,
    },

    methods: {

        // have to relay dismiss cause vue only $emit to the direct parent
        relayDismiss() {

            this.$emit('modal-dismiss');
        },
    },
};
