import { Request, Response } from "express";

import { ListProdutosUseCase } from "./ListProdutosUseCase";

class ListProdutosController {
  constructor(private listProdutosUseCase: ListProdutosUseCase) {}

  handle(request: Request, response: Response): Response {
    const all = this.listProdutosUseCase.execute();

    return response.json(all);
  }
}

export { ListProdutosController };
