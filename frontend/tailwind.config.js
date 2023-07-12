/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./index.html",
  "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    fontFamily: {
      'mono': ['Roboto Mono']
    },
    extend: {
      colors: {
        primary: '#24209F',
        secondary: '#33ACFF',
      },
    },
  },
  plugins: [],
}


        