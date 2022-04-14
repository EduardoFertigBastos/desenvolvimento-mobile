<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta
		name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no"
	/>
	<meta name="description" content="Eres tu unidavi" />
	<meta name="author" content="Soy yo" />

	<link rel="manifest" href="/manifest.json" crossorigin="use-credentials">
	<script src="/service-worker.js"></script>

	<title>RELÓGIO</title>

	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
		crossorigin="anonymous"
	/>
	<style>
		#relogio {
			margin: auto;
  			width: 50%;
			top: 50%;
			left: 50%;
			border: 7px solid red;
		}

		.img {
			margin: auto;
  			width: 50%;
			top: 50%;
			left: 50%;
			border: 7px solid red;
		}
	</style>
</head>
<body>

	<main class="container">
		<div id="relogio" class="text-center bg-primary" style="border: 1x solid red !important"></div>
		<div class="img">
			<img src="/assets/logo.png" alt="Logo parça">
		</div>
	</main>




	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"
	></script>

	<script>
		setInterval(() => {
			var d = new Date();

			document.getElementById('relogio').innerHTML =  (
				`${d.getDay().toString().padStart(2, '0')}/${(d.getMonth() + 1).toString().padStart(2, '0')}/${d.getFullYear()}
				${d.toLocaleTimeString('pt-BR')}`
			);			
		}, 1000);
	</script>
	
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
