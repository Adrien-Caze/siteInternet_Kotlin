fun cssStyles(): String = """
    <style>
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
              display: flex;
              flex-direction: column;
            }
            
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
            }

            .nav-logo {
              font-family: 'DM Serif Display', serif;
              font-size: 1.4rem;
              color: var(--accent);
              text-decoration: none;
              letter-spacing: -0.02em;
            }

            .nav-links {
              display: flex;
              gap: 2rem;
              list-style: none;
            }

            .nav-links a {
              text-decoration: none;
              font-size: 0.9rem;
              font-weight: 500;
              color: var(--muted);
              transition: color 0.2s;
            }

            .nav-links a:hover { color: var(--text); }

            .nav-cta {
              background: var(--accent);
              color: #fff !important;
              padding: 0.45rem 1.1rem;
              border-radius: 8px;
              transition: opacity 0.2s !important;
            }

            .nav-cta:hover { opacity: 0.85; }
            
            footer {
                background: var(--text);
                color: #9E9C96;
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
                margin-bottom: 0.5rem;
            }

            .footer-desc {
                font-size: 0.88rem;
                line-height: 1.65;
            }

            .footer-col h4 {
                font-size: 0.78rem;
                font-weight: 600;
                letter-spacing: 0.08em;
                text-transform: uppercase;
                color: #FAF9F6;
                margin-bottom: 1rem;
            }

            .footer-col ul {
                list-style: none;
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

            @media (max-width: 640px) {
            .nav-links { display: none; }
            .footer-inner { grid-template-columns: 1fr; gap: 2rem; }
            }
            
            .hero {
                text-align: center;
                padding: 5rem 2rem 3rem;
            }

            .hero-tag {
                display: inline-block;
                background: var(--accent-light);
                color: var(--accent);
                font-size: 0.78rem;
                font-weight: 600;
                letter-spacing: 0.08em;
                text-transform: uppercase;
                padding: 0.3rem 0.9rem;
                border-radius: 999px;
                margin-bottom: 1.25rem;
            }

            .hero h1 {
                font-family: 'DM Serif Display', serif;
                font-size: clamp(2.2rem, 5vw, 3.5rem);
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

            .hero-btn {
                display: inline-block;
                background: var(--accent);
                color: #fff;
                text-decoration: none;
                font-weight: 600;
                font-size: 0.95rem;
                padding: 0.75rem 2rem;
                border-radius: 10px;
                transition: opacity 0.2s, transform 0.2s;
            }

            .hero-btn:hover { opacity: 0.88; transform: translateY(-1px); }
            
            .cards {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
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
    }

    .card:hover {
      transform: translateY(-3px);
      box-shadow: 0 8px 24px rgba(0,0,0,0.07);
    }

    .card-icon {
      width: 44px;
      height: 44px;
      border-radius: 10px;
      display: flex;
      align-items: center;
      justify-content: center;
      font-size: 1.3rem;
    }

    .card-icon.green { background: #E1F5EE; }
    .card-icon.blue  { background: #E6F1FB; }
    .card-icon.amber { background: #FAEEDA; }

    .card h3 {
      font-size: 1.05rem;
      font-weight: 600;
      letter-spacing: -0.01em;
    }

    .card p {
      font-size: 0.92rem;
      color: var(--muted);
      line-height: 1.65;
    }

    .card-link {
      margin-top: auto;
      font-size: 0.88rem;
      font-weight: 600;
      color: var(--accent);
      text-decoration: none;
      display: inline-flex;
      align-items: center;
      gap: 4px;
      transition: gap 0.2s;
    }

    .card-link:hover { gap: 8px; }
    </style>
""".trimIndent()