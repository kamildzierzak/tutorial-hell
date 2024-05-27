## Next.js App Router Course - Starter

This is the starter template for the Next.js App Router Course. It contains the starting code for the dashboard application.

For more information, see the [course curriculum](https://nextjs.org/learn) on the Next.js Website.

## notes

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
