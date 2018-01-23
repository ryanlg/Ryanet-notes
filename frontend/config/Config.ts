export default interface Config {

    backendURL: string;
    backend(append: string):string;

    devServerPort: number;
}
