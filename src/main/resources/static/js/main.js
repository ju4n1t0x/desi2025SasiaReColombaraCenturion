// Función para cargar contenido dinámicamente
async function loadContent(url) {
    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error('Error al cargar el contenido');
        }
        const html = await response.text();
        const parser = new DOMParser();
        const doc = parser.parseFromString(html, 'text/html');
        
        // Actualizar el contenido principal
        const content = doc.getElementById('main-content').innerHTML;
        document.getElementById('main-content').innerHTML = content;
        
        // Actualizar la URL del navegador
        window.history.pushState({}, '', url);
    } catch (error) {
        console.error('Error:', error);
    }
}

// Manejar clics en los enlaces
document.addEventListener('DOMContentLoaded', () => {
    document.querySelectorAll('a[href]').forEach(link => {
        const href = link.getAttribute('href');
        if (href && href.startsWith('/')) {
            link.addEventListener('click', async (e) => {
                e.preventDefault();
                await loadContent(href);
            });
        }
    });
});