## Next.js App Router Course - Starter

This is the starter template for the Next.js App Router Course. It contains the starting code for the dashboard application.

For more information, see the [course curriculum](https://nextjs.org/learn) on the Next.js Website.

## Notes - Concepts, Ideas, Thoughts to Remember, Revisit, or Explore

To optimize data fetching in this application, we've:

- Created a database in the same region as your application to reduce latency between server and db.
- Fetched data on the server with React Server Components to keep expensive operations server-side, reduce client-side JavaScript, and protect database secrets.
- Used SQL to fetch only the necessary data, minimizing data transfer and in-memory transformations.
- Parallelized data fetching where appropriate.
- Implemented streaming to allow UI interaction before all data loads.
- Moved data fetching to specific components to prepare for Partial Prerendering.

Why use URL search params?

- bookmarkable and shareable URLs - params are part of the URL, so we can bookmark or share the current state of the app
- server-side rendering - the server can read the URL and render the correct content
- analytics and tracking - easier to track user interactions and behavior

Authentication:

- [Credentials (used in this app)](https://authjs.dev/getting-started/authentication/credentials)
- [OAuth (recommended)](https://authjs.dev/getting-started/authentication/oauth)
- [Email (recommended)](https://authjs.dev/getting-started/authentication/email)


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
