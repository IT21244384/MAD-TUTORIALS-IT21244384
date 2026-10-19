# Submission notes – Tutorial 03 (Fragments)

## What happens to the Cycling colour when you navigate? (sheet question)
Each time you press Walking/Driving, `replace(...)` removes the Cycling fragment's view. When you
come back, `onCreateView` inflates a **fresh** layout, so the background goes back to the default.
The colour was only stored in the view, which no longer exists.

**Fix used:** keep the choice in the activity-scoped `MainActivityData` ViewModel
(`cyclingBackground`). `CyclingFragment` writes it on every click and re-applies it in
`onCreateView`, so the colour is kept while navigating and when rotating the screen.

## Why a ViewModel for fragment ↔ activity communication?
Views inside a fragment aren't reachable by the activity. Both `MenuFragment` and `MainActivity`
obtain the same `MainActivityData` (`ViewModelProvider(requireActivity())` / `ViewModelProvider(this)`),
so the fragment sets a value and the activity observes it, with no direct reference between them.

## Test checklist – add screenshots
| # | Action | Expected |  |
|---|---|---|---|
| 1 | Launch | Menu with 3 buttons at top, empty area below | ☐ |
| 2 | Tap Walking / Cycling / Driving | Matching icon centred 📸 | ☐ |
| 3 | In Cycling tap Change Background Color | Background alternates two colours 📸 | ☐ |
| 4 | Go to Walking, then back to Cycling | Chosen colour is still applied | ☐ |
| 5 | Rotate device | Same fragment and colour remain | ☐ |
