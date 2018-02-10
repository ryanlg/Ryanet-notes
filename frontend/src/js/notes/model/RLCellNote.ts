export default class RLCellNote {

    id: number;
    name: string;
    modifiedTime: Date;
    excerpt: string;

    constructor(id: number, name: string, modifiedTime: Date, excerpt: string) {

        this.id = id;
        this.name = name;
        this.modifiedTime = modifiedTime;
        this.excerpt = excerpt;
    }
}
