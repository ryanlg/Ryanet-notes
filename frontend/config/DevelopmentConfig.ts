import { BaseConfig } from './BaseConfig';

export class DevelopmentConfig extends BaseConfig {

    public backendURL = 'http://localhost:8080/Ryanet';
}

export default new DevelopmentConfig();
