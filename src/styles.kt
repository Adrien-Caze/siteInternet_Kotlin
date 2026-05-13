fun cssStyles(): String = """
    <style>
        @import url('https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;500;600&family=DM+Serif+Display&display=swap');

        *, *::before, *::after { box-sizing: border-box; }

        :root {
          --bg: #FAF9F6;
          --surface: #FFFFFF;
          --text: #1C1C1A;
          --muted: #706F6B;
          --accent: #2A5C45;
          --accent-light: #E1F5EE;
          --border: #E2E0D8;
          --radius: 12px;
        }

        body {
          font-family: 'DM Sans', sans-serif;
          background: var(--bg);
          color: var(--text);
          min-height: 100vh;
          margin: 0;
          display: flex;
          flex-direction: column;
        }

        /* ─── NAVBAR ──────────────────────────────────── */

        nav {
          background: var(--surface);
          border-bottom: 1px solid var(--border);
          position: sticky;
          top: 0;
          z-index: 100;
        }

        .nav-inner {
          max-width: 1100px;
          margin: 0 auto;
          padding: 0 2rem;
          height: 64px;
          display: flex;
          align-items: center;
          justify-content: space-between;
          position: relative;
        }

        .nav-logo {
          font-family: 'DM Serif Display', serif;
          font-size: 1.4rem;
          color: var(--accent);
          text-decoration: none;
          letter-spacing: -0.02em;
          z-index: 110;
        }

        .nav-links {
          display: flex;
          gap: 2rem;
          list-style: none;
          margin: 0;
          padding: 0;
        }

        .nav-links a {
          text-decoration: none;
          font-size: 0.9rem;
          font-weight: 500;
          color: var(--muted);
          transition: color 0.2s;
        }

        .nav-links a:hover { color: var(--text); }

        /* Bouton hamburger (caché sur desktop) */
        .nav-toggle {
          display: none;
          flex-direction: column;
          justify-content: center;
          gap: 5px;
          background: none;
          border: none;
          cursor: pointer;
          padding: 0.5rem;
          z-index: 110;
        }

        .nav-toggle span {
          display: block;
          width: 24px;
          height: 2px;
          background: var(--text);
          border-radius: 2px;
          transition: transform 0.3s, opacity 0.3s;
        }

        .nav-toggle.open span:nth-child(1) { transform: translateY(7px) rotate(45deg); }
        .nav-toggle.open span:nth-child(2) { opacity: 0; }
        .nav-toggle.open span:nth-child(3) { transform: translateY(-7px) rotate(-45deg); }

        .nav-menu {
          display: flex;
          align-items: center;
        }

        /* ─── HERO ────────────────────────────────────── */

        .hero {
          text-align: center;
          padding: 5rem 2rem 3rem;
        }

        .hero h1 {
          font-family: 'DM Serif Display', serif;
          font-size: clamp(2rem, 5vw, 3.5rem);
          line-height: 1.15;
          letter-spacing: -0.02em;
          max-width: 680px;
          margin: 0 auto 1.2rem;
        }

        .hero p {
          font-size: 1.1rem;
          color: var(--muted);
          max-width: 520px;
          margin: 0 auto 2rem;
          line-height: 1.7;
        }

        /* ─── CONTAINER / CARDS ───────────────────────── */

        .container {
          max-width: 1100px;
          margin: 0 auto;
          padding: 0 2rem 4rem;
          width: 100%;
        }

        .section-title {
          font-family: 'DM Serif Display', serif;
          font-size: 1.6rem;
          letter-spacing: -0.02em;
          margin: 0 0 1.5rem;
          text-align: center;
        }

        .cards {
          display: grid;
          grid-template-columns: repeat(3, 1fr);
          gap: 1.25rem;
        }

        .card {
          background: var(--surface);
          border: 1px solid var(--border);
          border-radius: var(--radius);
          padding: 1.5rem;
          transition: transform 0.2s, box-shadow 0.2s;
          display: flex;
          flex-direction: column;
          gap: 0.75rem;
          text-align: left;
        }

        .card:hover {
          transform: translateY(-3px);
          box-shadow: 0 8px 24px rgba(0,0,0,0.07);
        }

        .card h3 {
          font-size: 1.05rem;
          font-weight: 600;
          letter-spacing: -0.01em;
          margin: 0;
        }

        .card p {
          font-size: 0.92rem;
          color: var(--muted);
          line-height: 1.65;
          margin: 0;
        }

        /* ─── FORMULAIRE CONTACT ──────────────────────── */

        .contact-section {
          max-width: 640px;
          margin: 0 auto;
          padding: 2rem 2rem 5rem;
          width: 100%;
        }

        .contact-header {
          text-align: center;
          margin-bottom: 2.5rem;
        }

        .contact-header h2 {
          font-family: 'DM Serif Display', serif;
          font-size: clamp(1.8rem, 4vw, 2.5rem);
          letter-spacing: -0.02em;
          margin: 0 0 0.5rem;
        }

        .contact-header p {
          font-size: 1rem;
          color: var(--muted);
          margin: 0;
        }

        .contact-card {
          background: var(--surface);
          border: 1px solid var(--border);
          border-radius: var(--radius);
          padding: 2.5rem;
        }

        .form-group {
          margin-bottom: 1.25rem;
        }

        .form-group label {
          display: block;
          font-size: 0.78rem;
          font-weight: 600;
          letter-spacing: 0.06em;
          text-transform: uppercase;
          color: var(--muted);
          margin-bottom: 0.4rem;
        }

        .form-group input,
        .form-group textarea {
          width: 100%;
          background: var(--bg);
          border: 1px solid var(--border);
          border-radius: 8px;
          padding: 0.75rem 1rem;
          font-family: 'DM Sans', sans-serif;
          font-size: 0.95rem;
          color: var(--text);
          outline: none;
          transition: border-color 0.2s, box-shadow 0.2s;
        }

        .form-group input:focus,
        .form-group textarea:focus {
          border-color: var(--accent);
          box-shadow: 0 0 0 3px rgba(42, 92, 69, 0.12);
          background: var(--surface);
        }

        .form-group textarea {
          height: 140px;
          resize: vertical;
        }

        .btn-contact {
          display: block;
          width: 100%;
          background: var(--accent);
          color: #fff;
          border: none;
          border-radius: 10px;
          padding: 0.85rem 2rem;
          font-family: 'DM Sans', sans-serif;
          font-size: 1rem;
          font-weight: 600;
          cursor: pointer;
          margin-top: 0.5rem;
          transition: opacity 0.2s, transform 0.2s;
        }

        .btn-contact:hover { opacity: 0.88; transform: translateY(-1px); }
        .btn-contact:active { transform: translateY(0); }

        /* ─── FOOTER ──────────────────────────────────── */

        footer {
          background: var(--text);
          color: #9E9C96;
          margin-top: auto;
        }

        .footer-inner {
          max-width: 1100px;
          margin: 0 auto;
          padding: 3rem 2rem;
          display: grid;
          grid-template-columns: 2fr 1fr 1fr;
          gap: 3rem;
        }

        .footer-brand {
          font-family: 'DM Serif Display', serif;
          font-size: 1.3rem;
          color: #FAF9F6;
          margin: 0 0 0.5rem;
        }

        .footer-col h4 {
          font-size: 0.78rem;
          font-weight: 600;
          letter-spacing: 0.08em;
          text-transform: uppercase;
          color: #FAF9F6;
          margin: 0 0 1rem;
        }

        .footer-col ul {
          list-style: none;
          padding: 0;
          margin: 0;
          display: flex;
          flex-direction: column;
          gap: 0.6rem;
        }

        .footer-col a {
          text-decoration: none;
          color: #9E9C96;
          font-size: 0.88rem;
          transition: color 0.2s;
        }

        .footer-col a:hover { color: #FAF9F6; }

        .footer-bottom {
          border-top: 1px solid #2C2C2A;
          text-align: center;
          padding: 1.25rem 2rem;
          font-size: 0.82rem;
        }

        /* ═══════════════════════════════════════════════
           RESPONSIVE
           Tablette  : max-width 1024px
           Mobile    : max-width 640px
        ═══════════════════════════════════════════════ */

        /* ── Tablette ─────────────────────────────────── */
        @media (max-width: 1024px) {
          .nav-inner { padding: 0 1.5rem; }

          .cards {
            grid-template-columns: repeat(2, 1fr);
          }

          .footer-inner {
            grid-template-columns: 1fr 1fr;
            gap: 2rem;
          }

          /* La colonne brand prend toute la largeur sur tablette */
          .footer-inner > div:first-child {
            grid-column: 1 / -1;
          }

          .hero { padding: 4rem 1.5rem 2.5rem; }
          .container { padding: 0 1.5rem 3rem; }
          .contact-section { padding: 1.5rem 1.5rem 4rem; }
        }

        /* ── Mobile ───────────────────────────────────── */
        @media (max-width: 640px) {
          /* Navbar : hamburger */
          .nav-inner { padding: 0 1.25rem; }

          .nav-toggle { display: flex; }

          .nav-menu {
            display: none;
            position: absolute;
            top: 64px;
            left: 0;
            right: 0;
            background: var(--surface);
            border-bottom: 1px solid var(--border);
            padding: 0.5rem 1.25rem 1rem;
            flex-direction: column;
            align-items: flex-start;
            box-shadow: 0 4px 12px rgba(0,0,0,0.06);
          }

          .nav-menu.open { display: flex; }

          .nav-links {
            flex-direction: column;
            gap: 0;
            width: 100%;
          }

          .nav-links li a {
            display: block;
            padding: 0.85rem 0;
            border-bottom: 1px solid var(--border);
            font-size: 1rem;
            color: var(--text);
          }

          .nav-links li:last-child a { border-bottom: none; }

          /* Hero */
          .hero { padding: 2.5rem 1.25rem 2rem; }
          .hero p { font-size: 1rem; }

          /* Cards */
          .container { padding: 0 1.25rem 2.5rem; }
          .cards { grid-template-columns: 1fr; }

          /* Contact */
          .contact-section { padding: 1.5rem 1.25rem 3rem; }
          .contact-card { padding: 1.5rem 1.25rem; }

          /* Footer */
          .footer-inner {
            grid-template-columns: 1fr;
            gap: 2rem;
            padding: 2rem 1.25rem;
          }

          .footer-inner > div:first-child {
            grid-column: auto;
          }

          .footer-bottom { padding: 1rem 1.25rem; }
        }
    </style>
""".trimIndent()