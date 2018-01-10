const path = require('path');
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;
const HtmlWebpackPlugin = require('html-webpack-plugin');

const entrypoint = './src/main.ts';
const filename = 'ryanet.js';
const output = './../dist';

function resolve (dir) {
    return path.join(__dirname, '..', dir);
} 


module.exports = {

    entry: entrypoint,

    output: {
        path: path.resolve(__dirname, output),
        filename: filename
    },

    module: {
        loaders: [

            {
                test: /\.vue$/,
                loader: 'vue-loader',
            },
            {
                test: /\.tsx?$/,
                loader: 'ts-loader',
                options: {
                    configFile: "tsconfig.json",
                },
            },


            {
                test: /\.js$/,
                loader: 'babel-loader',
                include: [resolve('src')]
            }
        ]
    },

    resolve: {
        extensions: ['.ts', '.js', '.vue', '.json'],
        modules: [
            path.resolve('./'),
            path.resolve('./node_modules'),
        ],
        alias: {
            // has to be vue.esm.js, or it adds extra .defualt to `new Vue`
            'vue$': 'vue/dist/vue.esm.js'
        }
    },

    plugins: [
        // uncomment for analyzer
        // new BundleAnalyzerPlugin({
        //     analyzerMode: 'static'
        // }),
        new HtmlWebpackPlugin({
            filename: 'index.html',
            template: 'index.html',
            inject: true
        })
    ],

    node: {
      // prevent webpack from injecting useless setImmediate polyfill because Vue
      // source contains it (although only uses it if it's native).
      setImmediate: false,
      // prevent webpack from injecting mocks to Node native modules
      // that does not make sense for the client
      dgram: 'empty',
      fs: 'empty',
      net: 'empty',
      tls: 'empty',
      child_process: 'empty'
    }
};