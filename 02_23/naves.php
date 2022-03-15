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

		<title>NASA</title>
		<link rel="manifest" href="/manifest.json" crossorigin="use-credentials">

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
								class="nav-link"
								aria-current="page"
								href="index.php"
								>Home</a
							>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="trabalhos.php"
								>Trabalhos Desenvolvidos</a
							>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="missoes.php"
								>Missões espaciais</a
							>
						</li>
						<li class="nav-item">
							<a class="nav-link active" href="naves.php"
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
				<h1>Naves Espaciais</h1>
			</div>
			<div class="row">
				<div class="col-12">
					<hr />
				</div>
			</div>

			<div class="row mb-4">
				<p class="lead">
					Ao todo, a Nasa desenvolveu 6 ônibus espaciais: Enterprise,
					Columbia, Challenger, Discovery, Atlantis e Endeavour. O
					Enterprise foi usado apenas para testes e não chegou à
					órbita da Terra. Já os demais, concluíram quase 32 mil horas
					de missões e levaram ao espaço 355 astronautas de 16 países.
				</p>

				<div
					class="col-sm-12 d-flex align-items-center justify-content-center"
				>
					<img
						class="img-fluid"
						src="https://img.olhardigital.com.br/wp-content/uploads/2021/07/5-onibus-espaciais-que-realizaram-missoes-em-orbita-da-Terra.jpg"
						alt="Nasa"
					/>
				</div>
			</div>
		</div>

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
