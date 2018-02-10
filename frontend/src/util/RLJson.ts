export default {

    contains(jsonObj: any, elm: any): boolean {

        let parsed: any;
        try {
            parsed = JSON.parse(jsonObj);
        } catch (e) {
            // it works!
            parsed = jsonObj;
        }

        if (elm.constructor === Array) {

            for (let i = 0; i < elm.length; i = i + 1) {

                if (!parsed.hasOwnProperty(elm[i])) {

                    return false;
                }
            }
        } else {

            if (!parsed.hasOwnProperty(elm)) {
                return false;
            }
        }

        return true;
    },
};
