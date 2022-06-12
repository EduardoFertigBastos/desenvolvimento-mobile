import { Request, Response } from "express";

import { UpdateProdutoUseCase } from "./UpdateProdutoUseCase";

class UpdateProdutoController {
  constructor(private updateProdutoUseCase: UpdateProdutoUseCase) {}

  handle(request: Request, response: Response): Response {
    const { id } = request.params;
    const { nome, descricao, preco } = request.body;

    this.updateProdutoUseCase.execute(id, { nome, descricao, preco });

    return response.send();
  }
}

export { UpdateProdutoController };
