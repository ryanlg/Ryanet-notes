/* tslint:disable */
// configs are handled by GeneralConfig
// so we can just use the dev server
import app from './dev-server';

app.get('/api/v1/note/list', (req, res) => {

    res.type('json');
    res.send('[{"id":1,"name":"Test One","modified_date":"2018-01-05T14:22:25Z"},{"id":2,"name":"Hello?","modified_date":"2018-01-05T14:22:27Z"},{"id":3,"name":"Circular Motion","modified_date":"2018-01-20T10:40:26Z"},{"id":4,"name":"Circular Motion","modified_date":"2018-01-20T10:43:07Z"},{"id":5,"name":"Motion In1D","modified_date":"2018-01-20T10:43:07Z"}]');
});

app.get('/api/v1/note/*', (req, res) => {

    res.type('json');
    res.send("{\"id\":1,\"name\":null,\"raw\":\"# gravity\\n\\n#### newton's law of " +
    "universal gravitation\\n$$\\n\\\\vec{F}_{12} = -G\\\\frac{m_1m_2}{r^2}\\\\hat{r}_{12}\\n$$\\n$$\\n\\\\vec{F}_{21} = -G\\\\frac{m_1m_2}{r^2}\\\\hat{r}_{21} = -\\\\vec{F}_{12}\\n$$\\n$$\\nG = 6.673 \\\\times 10^-11 \\\\, Nm^2/kg^2\\n$$\\n\\n#### kepler's first law\\n- all planets move in elliptical orbits with the sun at one focus\\n\\n#### kepler's second law\\n- the radius vector from sun to a planet sweeps out equal areas in equal time intervals\\n\\n#### kepler's third law\\n$$\\nT^2 = \\\\frac{4\\\\pi^2}{GM_{sun}}a^3 = K_s a^3 \\\\\\\\\\na = \\\\text{semimajor axis}\\n$$\\n\\n#### gravitational force\\n- it is a conservative force\\n$$\\nW = \\\\int_{r_i}^{r_f} \\\\vec{F}_g \\\\cdot d\\\\vec{r} = \\\\frac{Gm_1m_2}{r_f}-\\\\frac{Gm_1m_2}{r_i} = (-U_f) - (-U_i)\\n$$\\n\\n- a potential energy can be defined\\n$$\\nU = -\\\\frac{Gm_1m_2}{r}\\n$$\\n\\n#### equations\\n##### for a circular orbit\\n- force on m\\n$$\\nF_G = \\\\frac{GMm}{r^2}\\n$$\\n\\n- orbiting speed\\n$$\\nv^2 = \\\\frac{GM}{r}\\n$$\\n\\n- kinetic energy\\n$$\\nKE = \\\\frac12 mv^2\\n$$\\n\\n- potential energy\\n$$\\nU_G = -\\\\frac{GMm}{r} = -2 KE\\n$$\\n\\n- total energy\\n$$\\nE = KE + U_G = -\\\\frac12 (\\\\frac{GMm}{r}) = -KE\\n$$\\n\\n##### for a generic elliptical orbit\\n$$\\nE = -\\\\frac12 (\\\\frac{GMm}{a}) \\\\\\\\\\n\\\\text{a: semi-major axis}\\n$$\\n\\n#### escape speed\\n$$\\nv_{\\\\text{earth_esc}} = \\\\sqrt{\\\\frac{2GM_E}{R_E}} = 11.2 \\\\, km/s\\n$$\\n\\n#### Three Astronautical Speeds\\n##### first (orbiting near earth surface)\\n$$\\nv_1 = 7.9 km/s\\n$$\\n\\n##### second (escaping the earth)\\n$$\\nv_2 = 11.2 km/s\\n$$\\n\\n##### third (escaping solar system)\\n$$\\nv_3 = 16.7 km/s\\n$$\\n\",\"html\":null,\"createdDate\":\"2018-01-05T14:22:25Z\",\"modifiedDate\":\"2018-01-05T14:22:25Z\"}");
})
