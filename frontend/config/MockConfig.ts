import { DevelopmentConfig } from 'config/DevelopmentConfig';

export class MockConfig extends DevelopmentConfig {

    public backendURL = '';
}

export default new MockConfig();
