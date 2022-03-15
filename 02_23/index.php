<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta
			name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no"
		/>
		<meta name="description" content="" />
		<meta name="author" content="" />

		<script src="/service-worker.js"></script>
		<link rel="manifest" href="/manifest.json" crossorigin="use-credentials">
	
		<title>NASA</title>
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
			crossorigin="anonymous"
		/>
	</head>
	<body>
	
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container container-fluid">
				<a class="navbar-brand" href="#">NASA</a>
				<button
					class="navbar-toggler"
					type="button"
					data-bs-toggle="collapse"
					data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent"
					aria-expanded="false"
					aria-label="Toggle navigation"
				>
					<span class="navbar-toggler-icon"></span>
				</button>
				<div
					class="collapse navbar-collapse"
					id="navbarSupportedContent"
				>
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item">
							<a
								class="nav-link active"
								aria-current="page"
								href="index.php"
								>Home</a
							>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="trabalhos.php">Trabalhos Desenvolvidos</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="missoes.php"
								>Missões espaciais</a
							>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="naves.php"
								>Naves Espaciais</a
							>
						</li>
					</ul>
					<form class="d-flex">
						<input
							class="form-control me-2"
							type="search"
							placeholder="Search"
							aria-label="Search"
						/>
						<button class="btn btn-outline-success" type="submit">
							Search
						</button>
					</form>
				</div>
			</div>
		</nav>
		<div class="container mb-3">
			<div class="row text-center my-3">
				<h1>National Aeronautics and Space Administration</h1>
			</div>
			<div class="row">
				<div class="col-12">
					<hr />
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 col-md-6 col-lg-6 d-flex align-items-center justify-content-center">
					<img
						class="img-thumbnail"
						src="https://conteudo.imguol.com.br/c/entretenimento/1f/2020/07/17/nasa-pre-habilitacao-1595008254000_v2_900x506.jpg.webp"
						alt="Nasa"
					/>
				</div>
				<div class="col-sm-12 col-md-6 col-lg-6">
					<h4>O que é a nasa</h4>
					<p class="lead">
						A Nasa é uma agência independente do governo dos Estados
						Unidos, responsável pela pesquisa e pelo desenvolvimento
						de tecnologias relacionadas à exploração espacial e ao
						estudo do universo
					</p>

					<h4>
						Qual o objetivo da Nasa? 
					</h4>
					<p class="lead">
						A missão oficial da Nasa é fomentar
						o futuro da pesquisa espacial nos Estados Unidos. 
					</p>

					<h4>
						O que quer dizer a sigla Nasa? 
					</h4>
					<p class="lead">
						Nasa significa National Aeronautics and
						Space Administration, em inglês, que em tradução livre seria
						Administração Nacional da Aeronáutica e do Espaço
					</p>
				</div>
				<hr >
			</div>
		</div>
		<section class="row mt-3">
			<div class="col-4">
				<img class="img-thumbnail" src="https://static.poder360.com.br/2021/10/artemis-nasa.jpg" alt="Foto 1">
			</div>
			<div class="col-4">
				<img class="img-thumbnail" src="https://www.unicesumar.edu.br/wp-content/uploads/2020/09/NASA-SPACE-APPS-e1601391131131.jpg" alt="Foto 2">
			</div>
			<div class="col-4">
				<img class="img-thumbnail" src="https://s.yimg.com/ny/api/res/1.2/0hsqvDMjqy8cs19Sxq2z8A--/YXBwaWQ9aGlnaGxhbmRlcjt3PTY0MDtoPTQyNw--/https://s.yimg.com/os/creatr-images/2020-04/5e1493b0-74de-11ea-8bff-9446d39209cd" alt="Foto 3">
			</div>
			<div class="col-4">
				<img class="img-thumbnail" src="https://static.dw.com/image/60123744_605.png" alt="Foto 4">
			</div>
			<div class="col-4">
				<img class="img-thumbnail" src="https://ichef.bbci.co.uk/news/640/cpsprodpb/15DD1/production/_122935598_15ddca3f-0c7a-4d85-8952-953071724173.jpg" alt="Foto 5">
			</div>
			<div class="col-4">
				<img class="img-thumbnail" src="https://diariodonordeste.verdesmares.com.br/image/contentid/policy:1.3109608:1626270775/Lua-Nasa.jpg?f=default&$p$f=1df05eb" alt="Foto 6">
			</div>
		</section>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
			crossorigin="anonymous"
		></script>

		<script>
			if ('serviceWorker' in navigator) {
				navigator.serviceWorker.register('/service-worker.js')
				.then(function(registration) {
					console.log('Registration successful, scope is:', registration.scope);
				})
				.catch(function(error) {
					console.log('Service worker registration failed, error:', error);
				});
			}
		</script>
	</body>
</html>
