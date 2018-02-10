export default class RLNote {

    id: number;
    name: string;
    html: string;
    excerpt: string; // TODO: need this?
    modifiedTime: Date;

    constructor(id: number, name: string, content: string, excerpt: string, modifiedTime: Date) {

        this.id = id;
        this.name = name;
        this.html = content;
        this.excerpt = excerpt;
        this.modifiedTime = modifiedTime;
    }
}
