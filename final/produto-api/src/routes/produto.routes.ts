import { Router } from "express";

import { createProdutoController } from "../modules/produto/useCases/createProduto";
import { deleteProdutoController } from "../modules/produto/useCases/deleteProduto";
import { listProdutosController } from "../modules/produto/useCases/listProdutos";
import { updateProdutoController } from "../modules/produto/useCases/updateProduto";

const produtosRoutes = Router();

produtosRoutes.get("/", (request, response) => {
  return listProdutosController.handle(request, response);
});

produtosRoutes.post("/", (request, response) => {
  return createProdutoController.handle(request, response);
});

produtosRoutes.patch("/:id", (request, response) => {
  return updateProdutoController.handle(request, response);
});

produtosRoutes.delete("/:id", (request, response) => {
  return deleteProdutoController.handle(request, response);
});

export { produtosRoutes };
