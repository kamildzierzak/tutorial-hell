# tutorial-hell

## Notes - Concepts, Ideas, Thoughts to Remember, Revisit, or Explore

### Concepts

- **Interruptable Navigation**: Refers to a web or app navigation experience where ongoing navigation processes can be paused, stopped, or redirected based on user interactions or specific conditions.

- **Popping Effect**: Refers to a visual disruption that occurs when elements on a webpage load or appear at different times, causing a noticeable "pop" as each element becomes visible.

- **Partial Prerendering**: Refers to the process of prerendering only specific parts of a webpage, rather than the entire page, to improve the perceived performance and user experience. This technique delivers a fast-loading static shell for the main structure of the page, while dynamically loading and rendering the remaining content asynchronously.

- **Debouncing**: Is a technique to prevent a function from being called too frequently by delaying its execution until a specified period has passed since the last event.

  [**How Debouncing Works:**](https://nextjs.org/learn/dashboard-app/adding-search-and-pagination#:~:text=How%20Debouncing%20Works%3A)

  1. Trigger Event: When an event that should be debounced (like a keystroke in the search box) occurs, a timer starts.
  2. Wait: If a new event occurs before the timer expires, the timer is reset.
  3. Execution: If the timer reaches the end of its countdown, the debounced function is executed.

### Read

- [Cumulative Layout Shift - CLS](https://web.dev/articles/cls)
- [Improving Web Performance with Images](https://developer.mozilla.org/en-US/docs/Learn/Performance/Multimedia)
- [Web Fonts](https://developer.mozilla.org/en-US/docs/Learn/CSS/Styling_text/Web_fonts)
- [URLSearchParams](https://developer.mozilla.org/en-US/docs/Web/API/URLSearchParams)
- [Security with Server Ations in NextJS](https://nextjs.org/blog/security-nextjs-server-components-actions)

### Thoughts

> "With dynamic rendering, your application is only as fast as your slowest data fetch."

> "...authentication checks who you are, and authorization determines what you can do or access..."
