<template>
<!-- svg elements defined for the project -->
<svg hidden style="opacity: 0; width: 0; height: 0; position: absolute; top: 100%; left: 100%;">
    <defs>
        <!-- mask to cut out sections of the letter b -->
        <mask id="mask-b">
            <rect
                x="0"
                y="0"
                width="52"
                height="150"
                fill="#fff">
            </rect>
            <path
                d="M 14 14 h 20 a 3 3 0 0 1 3 3 v 6 a 3 3 0 0 1 -3 3 h -20 z"
                fill="#000">
            </path>
            <path
                d="M 14 44 h 20 a 3 3 0 0 1 3 3 v 6 a 3 3 0 0 1 -3 3 h -20 z"
                fill="#000">
            </path>
        </mask>
        <!-- mask to cut out the central section of the letter(s) o -->
        <mask id="mask-o">
            <rect
                x="0"
                y="0"
                width="50"
                height="150"
                fill="#fff">
            </rect>
            <!-- cut-out section replicating the letter o, but scaled from the center -->
            <g
                transform="translate(25 40) scale(0.5 0.6)">
                <g transform="translate(-25 -40)">
                    <path
                        fill="#000"
                        d="M 0 0 a 100 100 0 0 1 50 15 v 70 a 100 100 0 0 0 -50 -15 v -70">
                    </path>
                </g>
            </g>
        </mask>
        <!-- letter o
            including the mask and additional paths for the leaves above the letter
            ! this means the letters b and k need to be translated vertically to be aligned with the letter(s) o
        -->
        <symbol id="letter-o">
            <path
                transform="translate(0 21)"
                mask="url(#mask-o)"
                d="M 0 0 a 100 100 0 0 1 50 15 v 70 a 100 100 0 0 0 -50 -15 v -70">
            </path>
            <path
                d="M 50 31 a 100 100 0 0 0 -45 -20 v 5 a 100 100 0 0 1 45 15">
            </path>
            <path
                d="M 50 26 a 100 100 0 0 0 -22 -26 v 10 a 100 100 0 0 1 22 16">
            </path>
        </symbol>
        <!-- gradient overlaid on the books to give them a semitransparent shadow
        ! each book is mean to be 25 wide, hence the x2 value
        -->
        <linearGradient id="gradient-book" gradientUnits="userSpaceOnUse" y1="0" y2="0" x1="0" x2="25">
            <stop stop-color="#FF184A" offset="0"></stop>
            <stop stop-color="#311839" offset="1"></stop>
        </linearGradient>
        <!-- symbols describing the books included later in the project
            three variants with different patterns -->
        <symbol id="book-1">
            <g>
                <rect
                    fill="#FF184A"
                    x="5"
                    y="0"
                    width="15"
                    height="125"
                    rx="2">
                </rect>
                <rect
                    fill="#932243"
                    x="5"
                    y="5"
                    width="15"
                    height="10">
                </rect>
                <rect
                    fill="#932243"
                    x="5"
                    y="110"
                    width="15"
                    height="10">
                </rect>
                <rect
                    fill="url(#gradient-book)"
                    x="5"
                    y="0"
                    width="15"
                    height="125"
                    rx="2"
                    opacity="0.6">
                </rect>
            </g>
        </symbol>
        <symbol id="book-2">
            <g>
                <rect
                    fill="#FF184A"
                    x="0"
                    y="0"
                    width="25"
                    height="125"
                    rx="3.5">
                </rect>
                <rect
                    fill="#932243"
                    x="0"
                    y="10"
                    width="25"
                    height="2">
                </rect>
                <rect
                    fill="#932243"
                    x="0"
                    y="17"
                    width="25"
                    height="20">
                </rect>
                <rect
                    fill="#932243"
                    x="0"
                    y="42"
                    width="25"
                    height="2">
                </rect>
                <rect
                    fill="url(#gradient-book)"
                    x="0"
                    y="0"
                    width="25"
                    height="125"
                    rx="3.5"
                    opacity="0.6">
                </rect>
            </g>
        </symbol>
        <symbol id="book-3">
            <g>
                <rect
                    fill="#FF184A"
                    x="0.5"
                    y="25"
                    width="24"
                    height="100"
                    rx="5">
                </rect>
                <rect
                    fill="#932243"
                    x="5.5"
                    y="50"
                    width="2"
                    height="35">
                </rect>
                <rect
                    fill="#932243"
                    x="11.5"
                    y="45"
                    width="2"
                    height="45">
                </rect>
                <rect
                    fill="#932243"
                    x="17.5"
                    y="50"
                    width="2"
                    height="35">
                </rect>
                <rect
                    fill="url(#gradient-book)"
                    x="0.5"
                    y="25"
                    width="24"
                    height="100"
                    rx="5"
                    opacity="0.6">
                </rect>
            </g>
        </symbol>
        <symbol id="book-4">
            <g>
                <rect
                    fill="#FF184A"
                    x="6"
                    y="0"
                    width="13"
                    height="125"
                    rx="2">
                </rect>
                <rect
                    fill="#932243"
                    x="11.5"
                    y="12.5"
                    width="2"
                    height="100"
                    rx="2">
                </rect>
                <rect
                    fill="url(#gradient-book)"
                    x="6"
                    y="0"
                    width="13"
                    height="125"
                    rx="2"
                    opacity="0.6">
                </rect>
            </g>
        </symbol>
    </defs>
</svg>


<!-- html structure
.app, wrapping container
    header
        svg
    form
        label, input and submit button
    section
        one article for each book, nesting an svg element and a div describing the book
        ! elements added through the script following the fetch request
-->
<div class="app">
    <header>
        <svg viewBox="0 0 240 106" width="240" height="106">
            <g fill="currentColor">
                <!-- b -->
                <g transform="translate(0 21)">
                    <path
                        mask="url(#mask-b)"
                        d="M 0 0 h 40 a 12 12 0 0 1 12 12 v 18 a 5 5 0 0 1 -5 5 a 5 5 0 0 1 5 5 v 18 a 12 12 0 0 1 -12 12 h -40">
                    </path>
                </g>
                <!-- o -->
                <g transform="translate(64 0)">
                    <use href="#letter-o"></use>
                </g>
                <!-- o scaled with a negative x value to create a mirrored version -->
                <g transform="translate(69 0)">
                    <!-- scaled from the right edge of the letter -->
                    <g transform="translate(50 0) scale(-1 1)">
                        <g transform="translate(-50 0)">
                            <use href="#letter-o"></use>
                        </g>
                    </g>
                </g>
                <!-- k -->
                <g transform="translate(181 21)">
                    <path
                        d="M 0 0 v 70 h 15 v -30 l 24 30 h 20 l -28 -35 l 28 -35 h -20 l -24 30 v -30 z">
                    </path>
                </g>
            </g>
        </svg>
    </header>

</div>
<div class="wrapper">
<button @click="$router.push('register')" class="button button2">Sign Up</button>
<button @click="$router.push('login')" class="button button2">Login</button>

</div>
</template>
<style scoped>
@import url("https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap");
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}
.button2 {
  background-color: white; 
  color: black; 
  border: 2px solid #008CBA;
  border-radius: 4px;
}

.button2:hover {
  background-color: #008CBA;
  color: white;
}

* {
  box-sizing: border-box;
  padding: 0;
  margin: 0;
}


body {
  min-height: 100vh;
  background: #180b24;
  color: #ffffff;
  font-family: "Open Sans", sans-serif;
  /* center the .app container horizontally */
  display: flex;
  justify-content: center;
}
/* display the header, form and section in a single column */
.app {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 3rem 1rem;
}
/* display the input and submit button side by side, with the former growing to cover the available space */
.app form {
  margin: 3.5rem 0;
  display: flex;
  align-items: center;
  position: relative;
  border-bottom: 2px solid currentColor;
}
/* absolute position the label above the form */
.app form label {
  z-index: -5;
  position: absolute;
  bottom: 100%;
  left: 0;
  font-size: 0.75rem;
  text-transform: uppercase;
  transition: opacity 0.2s ease-out;
  transition-delay: 0.15s; /* small delay as the focus is removed */
}
/* when the form has focus reduce the weight of the label */
.app form:focus-within label {
  opacity: 0.7;
  transition-delay: 0; /* no delay as the focus is gained */
}

/* when the form has focus animate the svg to rotate back to 0 */
.app form:focus-within button svg {
  transform: rotate(0);
  transition-delay: 0.15s; /* small delay as the focus is gained */
}
.app form input {
  outline: none;
  flex-grow: 1;
  font-family: inherit;
  font-size: 1.2rem;
  color: inherit;
  background: none;
  border: none;
  padding: 0.5rem 0;
}
.app form button {
  margin-left: 0.5rem;
  background: none;
  border: none;
  width: 45px;
  height: 45px;
  color: inherit;
  padding: 5px;
}
/* rotate the svg by default */
.app form button svg {
  transition: transform 0.25s ease-out;
  transform: rotate(45deg);
  width: 100%;
  height: 100%;
  display: block;
}
/* display the articles in a row */
.app section {
  display: flex;
  align-items: flex-end;
  position: relative;
}
/* animate the articles to appear one after another (delay included in the script) */
.app section article {
  color: inherit;
  text-decoration: none;
  padding: 0 0.25rem;
  animation: addBook 0.7s ease-out both;
  /* position relative to absolute position the div describing the book below the article */
  position: relative;
}
/* animation for the articles */
@keyframes addBook {
  from {
    opacity: 0;
    visibility: hidden;
  }
  to {
    opacity: 1;
    visibility: visible;
  }
}
/* when hovering the articles scale the svg element to as if picking out the book */
.app section article svg {
  transition-property: transform, opacity;
  transition-duration: 0.15s;
  transition-timing-function: ease-in-out;
  transform-origin: 50% 100%;
  opacity: 0.8;
}
.app section article:hover svg {
  transform: scale(1.1);
  opacity: 1;
}
/* position the container describing the book below the svg */
.app section article div {
  position: absolute;
  top: 100%;
  left: 50%;
  transform: translate(-50%, 5px);
  white-space: nowrap;
  background: #fff;
  color: #000;
  /* include more whitespace atop the container to make space for the clip-path */
  padding: 0.5rem 1rem;
  padding-top: 1rem;
  /* add an arrow pointing upwards by clipping the background */
  clip-path: polygon(
    0% 0.5rem,
    42% 0.5rem,
    50% 0%,
    58% 0.5rem,
    100% 0.5rem,
    100% 100%,
    0% 100%
  );
  /* by default hide the container */
  pointer-events: none;
  opacity: 0;
  visibility: hidden;
}
/* on hover show the container describing the information */
.app section article:hover div {
  /* transition only as the hover event occurs */
  transition-property: opacity, visibility;
  transition-duration: 0.15s;
  transition-timing-function: ease-in-out;
  transition-delay: 0.1s;
  opacity: 1;
  visibility: visible;
}
.app section article div h1 {
  font-size: 1rem;
}
.app section article div h2 {
  font-size: 0.9rem;
}
.app section article div p {
  font-size: 0.9rem;
}

</style>
<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
  }
}
</script>
